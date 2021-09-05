package Class2.TechbowBadgeSystem;

import Class3.TechbowBadgeSystem.IValidationService;
import Class3.TechbowBadgeSystem.Rules.IValidateRule;
import Class3.TechbowBadgeSystem.UserInfo;

import java.util.List;

/**
 * Created by FLK on 2019-12-27.
 */
public class ValidateServiceImpl implements IValidationService {
    /*
     * 1. Query DB and get the level
     * 2. Make Service Call
     */
    @Override
    public int getUserSecurityLevel(String userId) {
        return 0;
    }

    @Override
    public int getCheckerSecurityLevel(String checkerId) {
        return 0;
    }

    @Override
    public String getUserCurrentBadgeId(String userId) {
        return null;
    }

    @Override
    public List<IValidateRule> getCheckerValidationRules(String checkerId) {
        return null;
    }

    @Override
    public UserInfo getUserInfo(String userId) {
        return null;
    }
}
