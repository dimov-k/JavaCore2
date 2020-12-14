public class Main {
    private static final int size = 10000000;
    private static final int half = size / 2;

    public float[] formula(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void runOneThread() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        formula(arr);
        System.out.println("First Method: " + (System.currentTimeMillis() - a));
    }

    public void runTwoThreads() {
        float[] arr = new float[size];
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);

        new Thread(() -> {
            float[] a1 = formula(arr1);
            System.arraycopy(a1, 0, arr1, 0, a1.length);
        }).start();

        new Thread(() -> {
            float[] a2 = formula(arr2);
            System.arraycopy(a2, 0, arr2, 0, a2.length);
        }).start();

        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
        System.out.println("Secondary Method: " + (System.currentTimeMillis() - a));
    }

    public static void main(String s[]) {
        Main o = new Main();
        o.runOneThread();
        o.runTwoThreads();
    }
}
