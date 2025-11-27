package KunalKushwaha.Assignments.Math;

public class QueriesOnNumberOfPointsInsideACircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] pointsInside = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int circleX = queries[i][0];
            int circleY = queries[i][1];
            int r = queries[i][2];
            int rSq = r * r;
            int count = 0;

            for(int j = 0; j < points.length; j++){
                int pointX = points[j][0];
                int pointY = points[j][1];

                int dx = pointX - circleX;
                int dy = pointY - circleY;

                if(dx*dx + dy*dy <= rSq) {
                    count++;
                }
            }
            pointsInside[i] = count;
        }

        return pointsInside;
    }
}
