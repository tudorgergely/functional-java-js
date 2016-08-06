package immutability;

import immutability.model.ImmutableDog;
import immutability.model.MutableDog;

public class MutabilityExamples {

    private MutableDog mutableDog;
    private ImmutableDog immutableDog;

    public MutabilityExamples() {
        mutableDog = new MutableDog();
        mutableDog.setId(1);
        mutableDog.setName("Rex");
        mutableDog.setWeight(12);
        immutableDog = new ImmutableDog(2, "ImmutableRex", 13);
    }

    public MutableDog getMutableDog() {
        return mutableDog;
    }

    public ImmutableDog getImmutableDog() {
        return immutableDog;
    }

    public MutableDog renameDog(String name) {
        mutableDog.setName(name);
        return mutableDog;
    }

    public ImmutableDog pureRenameDog(String name) {
        return new ImmutableDog(immutableDog.getId(), name, immutableDog.getWeight());
    }
}
