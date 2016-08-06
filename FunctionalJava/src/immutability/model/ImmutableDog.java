package immutability.model;

public class ImmutableDog extends Dog {

    public ImmutableDog(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public ImmutableDog changeId(int id) {
        return new ImmutableDog(id, name, weight);
    }

    public ImmutableDog changeName(String name) {
        return new ImmutableDog(id, name, weight);
    }

    public ImmutableDog changeWeight(int weight) {
        return new ImmutableDog(id, name, weight);
    }
}
