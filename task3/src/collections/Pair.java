package collections;

class Pair {
    public Object key;
    public Object value;

    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object objToCompare) {
        boolean result = (objToCompare instanceof Pair && ((Pair) objToCompare).key.equals(key));
        result = result || objToCompare.equals(key);
        return result;
    }

    @Override
    public String toString() {
        return (key.toString() + " : " + value.toString());
    }
}
