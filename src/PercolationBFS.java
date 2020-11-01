import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class PercolationBFS extends PercolationDFSFast{

    public PercolationBFS(int x) {
        super(x);
    }

    @Override
    protected void dfs(int row, int col) {
        if (!inBounds(row,col)) return;
        myGrid[row][col] = FULL;
        Queue<Integer> q = new LinkedList<>();
        q.add((row * myGrid.length) + col);
        while(q.size() != 0) {
            int guy = q.remove();
            int rcord = guy / myGrid.length;
            int ccord = guy % myGrid.length;

            if(inBounds(rcord, ccord + 1) && isOpen(rcord, ccord + 1) && !isFull(rcord, ccord +1))
            {
                myGrid[rcord][ccord + 1] = FULL;
                q.add(rcord * myGrid.length + ccord + 1);
            }
            if(inBounds(rcord, ccord - 1) &&  isOpen(rcord, ccord - 1) && !isFull(rcord, ccord - 1))
            {
                myGrid[rcord][ccord - 1] = FULL;
                q.add(rcord  *myGrid.length + ccord - 1);
            }
            if(inBounds(rcord + 1, ccord) && isOpen(rcord + 1, ccord) && !isFull(rcord + 1, ccord))
            {
                myGrid[rcord + 1][ccord] = FULL;
                q.add((rcord+1)*myGrid.length + ccord);
            }
            if(inBounds(rcord - 1, ccord) && isOpen(rcord - 1, ccord) && !isFull(rcord - 1, ccord) )
            {
                myGrid[rcord - 1][ccord] = FULL;
                q.add((rcord - 1) * myGrid.length + ccord);
            }
        }
    }
}
