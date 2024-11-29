class Main {
  public static void main(String args[]) {
        System.out.println(compute(x, y, wind));
    }

    public static int compute(int X, int Y, double wind) {
        double P = 80;
        double g = 0.07102;
        double v = 0.0714 * P + 1.47;
        double v_w = 0.0587 * wind;
        X = ((X*84)/201)-119;
        Y = (Y*84)/201;
        
        double min_diff = 1000;
        int best_angle = 0;
        for (int a = 60; a < 90; a++) {
            double _a = Math.toRadians(a);
            double t = (v * Math.sin(_a) + Math.sqrt(Math.pow(v * Math.sin(_a), 2) - 2 * g * Y)) / g;
            double _X = t * (v * Math.cos(_a) + v_w);

            double diff = Math.abs(_X - X);
            if(diff < min_diff){
                min_diff = diff;
                best_angle = a;
            }
        }
        return best_angle;
    }
}
