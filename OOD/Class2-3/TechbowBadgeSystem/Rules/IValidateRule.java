package Class3.TechbowBadgeSystem.Rules;

import Class3.TechbowBadgeSystem.UserInfo;
import com.sun.istack.internal.NotNull;

/**
 * Created by FLK on 2019-12-27.
 */
public interface IValidateRule {
    boolean isValid(@NotNull final UserInfo userInfo);
}
