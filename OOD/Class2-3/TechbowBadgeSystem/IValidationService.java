package Class3.TechbowBadgeSystem;


import Class3.TechbowBadgeSystem.Rules.IValidateRule;

import java.util.List;

/**
 * Created by FLK on 2019-12-27.
 */
public interface IValidationService {
    int getUserSecurityLevel(final String userid);

    int getCheckerSecurityLevel(final String checkerId);

    UserInfo getUserInfo(final String userId);

    List<IValidateRule> getCheckerValidationRules(String checkerId);

    String getUserCurrentBadgeId(String userId);
}
