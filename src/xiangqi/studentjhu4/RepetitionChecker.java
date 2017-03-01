package xiangqi.studentjhu4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;
import xiangqi.common.XiangqiPiece;

public class RepetitionChecker {
	private ArrayList<String> moveHashes;
	private int checkrange;
	private int repetition;
	public RepetitionChecker(int range, int repetition){
		moveHashes=new ArrayList<String>();
		this.checkrange=range;
		this.repetition=repetition-1;
	}
	
	/**
	 * Check if the move is a repetition move
	 * @param move XiangqiMove that a player made
	 * @return true if it is a repetition move, false otherwise
	 */
	public boolean isRepetitionMove(XiangqiMove move){
		String newest=hashMoveToString(move);
		int count=0;
		int exclusiveLowerBound=(moveHashes.size()-checkrange)>0?(moveHashes.size()-checkrange):0;
		for(int i=moveHashes.size()-1;i>exclusiveLowerBound;i--){
			if(newest.equals(moveHashes.get(i))){
				count++;
			}
			if(count>=repetition){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Update the check with a move
	 * @param move XiangqiMove that a player made
	 */
	public void update(XiangqiMove move) {
		moveHashes.add(hashMoveToString(move));
	}
	
	private String hashMoveToString(XiangqiMove move){
		HashMap<Integer,XiangqiPiece> redpieces=new HashMap<Integer,XiangqiPiece>(move.redpieces);
		HashMap<Integer,XiangqiPiece> blackpieces=new HashMap<Integer,XiangqiPiece>(move.blackpieces);
		SortedSet<Integer> redkeys = new TreeSet<Integer>(move.redpieces.keySet());
		SortedSet<Integer> blackkeys = new TreeSet<Integer>(move.blackpieces.keySet());
		String result = "r";
		for (Integer key : redkeys) { 
			result+=key.toString();
			result+=redpieces.get(key).getPieceType().getSymbol();
		}
		result+="b";
		for (Integer key : blackkeys) {
			result+=key.toString();
			result+=blackpieces.get(key).getPieceType().getSymbol();
		}
		return result;
	}
}
