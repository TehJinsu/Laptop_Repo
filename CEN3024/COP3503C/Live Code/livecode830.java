public class Main {
    
}

public static float closestPair(ArrayList<Point> pts) {
    //using comparator class and lambda excpresions
    Comparator<Point> comparebyx = (Point p1, Point p2) -> p1.getX().compareTo(p2.getX()); // try to learn lambda expressions shit looks clean as fuck
    Collections.sort(pts, comparebyx);

    return closestPairR(pts, 0, pts.size() - 1)

}

public static float closestPairR(ArrayList<Point> pts, int i, int j) {

    //three or fewer points
    if(j - i < 3) {
        Comparator<Point> comparebyy = (Point p1, Point p2) -> p1.getY().compareTo(p2.getY());
        Collections.sort(pts,comparebyy);

        //delta value 
        float delta = distance(pts.get(i), pts.get(i + 1));
        
        //this is for 2 points only
        if(j - i == 1){
            return delta;
        }

        //for three points
        if(distance(pts.get(i + 1), pts.get(i + 2)) < delta) {
            delta = distance(pts.get(i + 1), pts.get(i + 2));
        }

        if(distance(pts.get(i), pts.get(i + 2)) < delta) {
            delta = distance(pts.get(i), pts.get(i + 2));
        }

        return delta;
    }

    int k = (i + j) / 2;

    float l = pts.get(k).getX();

    float deltal = closestPairR(pts, i, k);
    float deltar = dlosestPairR(pts, k + 1, j);

    float delta = Math.min(deltal,deltar);

    ArrayList<Point> midline = new ArrayList<Point>();

    //find pts part of that midline
    int t = 0;

    for(int x = i; x <= j; ++x) {
        if(pts.get(x).getX() > l - delta && pts.get(x).getX() < l + delta) {
            ++t;
            midline.add(new Points(pts.get(x)));

        }
    }

    float min = delta;

    Comparator<Point> comparebyy = (Point p1, Point p2) -> p1.getY().compareTo(p2.getY());
        Collections.sort(midline,comparebyy);

    for(int x = 0; x < t; ++x) {
        for
    }

}