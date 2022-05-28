public class FirstDayBeenInAllRooms {
    int n;
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        n = nextVisit.length;
        int[] rooms = new int[n];
        int count = 1;
        rooms[0] = 1;

        int next;
        int cur = 0;
        int visitNum = 1;
        while(count < n) {
            if (rooms[cur]%2==1) {
                next = nextVisit[cur];
            } else {
                next = (cur + 1) % n;
            }
            cur = next;
            if (rooms[cur] == 0) {
                count += 1;
            }
            rooms[cur] += 1;
            visitNum += 1;
        }
        return visitNum-1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,2};
        int res = new FirstDayBeenInAllRooms().firstDayBeenInAllRooms(nums);
        System.out.println(res);
    }
}
