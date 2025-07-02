class loopc {
    public static void main(String[] args) {
        int x = 0;
        int i = 2;
        int count = 0;
        do {
            x = x + 1;
            count++;
            i += 2;
        } while (i <= 100);
        System.out.println(count);
    }
}
