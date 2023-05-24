class Bitset {
    private int[] bits;

    public Bitset(int size) {
        bits = new int[size];
    }

    public void fix(int idx) {
        bits[idx] = 1;
    }

    public void unfix(int idx) {
        bits[idx] = 0;
    }

    public void flip() {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = (bits[i] == 0) ? 1 : 0;
        }
    }

    public boolean all() {
        for (int bit : bits) {
            if (bit == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean one() {
        for (int bit : bits) {
            if (bit == 1) {
                return true;
            }
        }
        return false;
    }

    public int count() {
        int count = 0;
        for (int bit : bits) {
            if (bit == 1) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int bit : bits) {
            sb.append(bit);
        }
        return sb.toString();
    }
}
