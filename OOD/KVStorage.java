package OOD;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class KVStorage {
    private LinkedList<TransactionNode> nodes;

    public KVStorage() {
        nodes = new LinkedList<>();
        nodes.add(new TransactionNode());
    }

    public String get(String key) {
        return nodes.getLast().get(key);
    }

    public void set(String key, String value) {
        nodes.getLast().set(key, value);
    }

    public void start() {
        TransactionNode node = new TransactionNode();
        node.setParent(nodes.getLast());
        nodes.add(node);
    }

    public boolean abort() {
        if (nodes.size() <= 1) return false;
 
        nodes.removeLast();
        return true;
    }

   public boolean commit() {
       if (nodes.size() <= 1) return false;

       TransactionNode removeNode = nodes.removeLast();
       TransactionNode commitNode = nodes.getLast();
       for (String key : removeNode.getKeyValue().keySet()) {
            String value = removeNode.getKeyValue().get(key);
            commitNode.getKeyValue().put(key, value);
       }

       return true;
   }

   public static void main(String[] args) {
       KVStorage db = new KVStorage();
       Scanner scanner = new Scanner(System.in);
       scanner.useDelimiter("\\s+");
       String cmdLine;

       while (scanner.hasNextLine()) {
           cmdLine = scanner.nextLine().trim();
           String[] tokens = cmdLine.split("\\s+");
           String command = tokens[0].toUpperCase();
           String key, value;

           try {
               switch (command) {
                   case "READ":
                        key = tokens[1];
                        System.out.println(db.get(key) == null ? "Key not found: " + key : db.get(key));
                        break;
                    case "WRITE":
                        key = tokens[1];
                        value = tokens[2];
                        db.set(key, value);
                        break;
                    case "DELETE":
                        key = tokens[1];
                        db.set(key, null);
                        break;
                    case "START":
                        if (tokens.length > 1) {
                            System.out.println("START operation can not take extra parameter");
                            break;
                        }
                        db.start();
                        break;
                    case "ABORT":
                        if (tokens.length > 1) {
                            System.out.println("ABORT operation can not take extra parameter");
                            break;
                        }
                        if (!db.abort()) System.out.println("You don't have transaction to abort");
                        break;
                    case "COMMIT":
                        if (tokens.length > 1) {
                            System.out.println("COMMIT operation can not take extra parameter");
                            break;
                        }
                        if (!db.commit()) System.out.println("You don't have transaction to commit");
                        break;
                    case "QUIT":
                        if (tokens.length > 1) {
                            System.out.println("QUIT operation can not take extra parameter");
                            break;
                        }
                        System.out.println("Exiting...");
                        return;
                    case "":
                        break;
                    default:
                        System.out.println("Unknown command: " + command);
               }
           } catch (ArrayIndexOutOfBoundsException e) {
               System.out.println("Incorrect number of tokens: " + command);
           }
       }

       scanner.close();
   }
}

class TransactionNode {
    private TransactionNode parent;
    private Map<String, String> keyValue = new HashMap<>();

    public TransactionNode() {
    }

    public TransactionNode(Map<String, String> map) {
        keyValue = map;
    }

    public void setParent(TransactionNode node) {
        parent = node;
    }

    public Map<String, String> getKeyValue() {
        return keyValue;
    }

    public String get(String key) {
        TransactionNode curBlock = this;
        String value = curBlock.keyValue.get(key);
        while (!curBlock.keyValue.containsKey(key) && curBlock.parent != null) {
            curBlock = curBlock.parent;
            value = curBlock.keyValue.get(key);
        }

        return value;
    }

    public void set(String key, String value) {
        keyValue.put(key, value);
    }
}
