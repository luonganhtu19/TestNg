package firebase.entity;

import java.util.List;

public interface EntityManager {
    ValidateResult validate(Entity var1);

    ValidateResult validate(Entity var1, List<String> var2);

}
