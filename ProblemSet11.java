import java.util.*;

public class ProblemSet11 {

    public static void main(String[] args) {

    }

    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start < end) {
            int track = start;
            ArrayList<String> tmp = new ArrayList<>();
            while (track < end) {
                if (track % 3 == 0) {
                    if (track % 5 == 0) {
                        tmp.add("FizzBuzz");
                    } else {
                        tmp.add("Fizz");
                    }
                } else if (track % 5 == 0) {
                    tmp.add("Buzz");
                } else {
                    tmp.add(String.valueOf(track));
                }
                track++;
            }
            return tmp;
        }
        return null;
    }

    public int maxSpan(ArrayList<Integer> numbers) {
        if (numbers != null) {
            if(numbers.size() == 0){
		    return 0;
	    }
	    if(numbers.size() == 1){
		    return 1;
	    }
            int max = 1;
            for (int i = 0; i < numbers.size(); i++) {
                int num = numbers.get(i);
                for (int m = numbers.size() - 1; m > i; m--) {
                    if (numbers.get(m) == num && max < (m - i + 1)) {
                        max = m - i + 1;
                    }
                }
            }
            return max;
        }
        return -1;
    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        if (numbers != null) {
            ArrayList<Integer> fourTrack = new ArrayList<>(); ArrayList<Integer> threeTrack = new ArrayList<>();
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == 3) {
                    threeTrack.add(i);
                } else if (numbers.get(i) == 4) {
                    fourTrack.add(i);
                }
            }
            if (fourTrack.size() == threeTrack.size() && threeTrack.get(0) < fourTrack.get(0)) {
                boolean bin = true;
                for (int i = 0; i < numbers.size() - 1; i++) {
                    if (numbers.get(i) == 3 && numbers.get(i + 1) == 3) {
                        bin = false;
                    }
                }

                if (bin) {
                    for (int i = 0; i < fourTrack.size(); i++) {
                        numbers.remove(Integer.valueOf(4));
                    }
                    for (int i = 0; i < threeTrack.size(); i++) {
                        numbers.remove(Integer.valueOf(3));
                    }
                    for (int i = 0; i < threeTrack.size(); i++) {
                        numbers.add(threeTrack.get(i), 3);
                        numbers.add(threeTrack.get(i) + 1, 4);
                    }
                    return numbers;
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        if (numbers != null) {
	    ArrayList<Integer> fourTrack = new ArrayList<>(); ArrayList<Integer> fiveTrack = new ArrayList<>();
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == 5) {
                    fiveTrack.add(i);
                } else if (numbers.get(i) == 4) {
                    fourTrack.add(i);
                }
            }
            if (fourTrack.size() == fiveTrack.size()) {
                boolean bin = true;

                for (int i = 0; i < numbers.size() - 1; i++) {
                    if (numbers.get(i) == 4 && numbers.get(i + 1) == 4) {
                        bin = false;
                    }
                }
                if (bin) {
                    for (int i = 0; i < fourTrack.size(); i++) {
                        numbers.remove(Integer.valueOf(4));
                    }
                    for (int i = 0; i < fiveTrack.size(); i++) {
                        numbers.remove(Integer.valueOf(5));
                    }
                    for (int i = 0; i < fiveTrack.size(); i++) {
                        numbers.add(fourTrack.get(i), 4);
                        numbers.add(fourTrack.get(i) + 1, 5);
                    }

                    return numbers;
                }
            }
        }
        return null;
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if (numbers != null && numbers.size() > 0) {
            for (int i = 0; i < numbers.size(); i++) {
                ArrayList<Integer> start = new ArrayList<Integer>(numbers.subList(0, i + 1));
                ArrayList<Integer> end = new ArrayList<Integer>(numbers.subList(i + 1, numbers.size()));
                int sInt = 0; int eInt = 0;
                for (int n : start) {
                    sInt += n;
                }
                for (int n : end) {
                    eInt += n;
                }
                if (sInt == eInt) return true;
            }
        }
        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {
        if (outer != null 
	&& inner != null 
	&& outer.size() > 0 
	&& inner.size() > 0) 
	{
            for (int i = 0; i < inner.size() - 1; i++) {
                if (inner.get(i) > inner.get(i + 1))
                    return false;
            }
            for (int i = 0; i < outer.size() - 1; i++) {
                if (outer.get(i) > outer.get(i + 1)) {
                    return false;
                }
            }
            int track = 0;
            for (int i = 0; i < inner.size(); i++) {
                for (int m : outer) {
                    if (m == inner.get(i)) {
                        track++;
                        break;
                    }
                }
            }
            if (track < inner.size()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public ArrayList<Integer> squareUp(int n) {
        if (n >= 0) {
            if (n == 0) {
                ArrayList<Integer> returnMeZero = new ArrayList<Integer>(0); return returnMeZero;
            }
            ArrayList<Integer> returnMe = new ArrayList<Integer>();
            for (int i = n; i > 0; i--) {
                int track = i - 1;
                for (int m = 0; m < n; m++) {
                    if (track > 0) {
                        returnMe.add(0);
                    } else {
                        returnMe.add(n - m);
                    }
                    track--;
                }
            }
            return returnMe;
        }
        return null;
    }

    public ArrayList<Integer> seriesUp(int n) {
        if (n >= 0) {
            if (n == 0) {
                ArrayList<Integer> output = new ArrayList<Integer>(0);
                return output;
            }
            ArrayList<Integer> array = new ArrayList<Integer>();
            int length = 1;
            for (int i = 0; i < n; i++) {
                int count = 1;
                for (int m = 0; m < length; m++) {
                    array.add(count); count++;
                }
                length++;
            }
            return array;
        }
        return null;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        if (numbers != null) {
            int track1 = numbers.size(); int track2 = track1;
            int[][] doubleArr = new int[track1 + 1][track2 + 1];
            int returnMe = 0;
            for (int i = 0; i <= track1; i++) {
                for (int m = 0; m <= track2; m++) {
                    if (i == 0 || m == 0) {
                        doubleArr[i][m] = 0;
                    } else if (numbers.get(i - 1) == numbers.get(track2 - m)) {
                        doubleArr[i][m] = doubleArr[i - 1][m - 1] + 1;
                        returnMe = Math.max(returnMe, doubleArr[i][m]);
                    } else {
                        doubleArr[i][m] = 0;
                    }
                }
            }
            return returnMe;
        }
        return -1;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        if (numbers != null) {
            int track = numbers.get(0); int prev1 = track; 
	    int prev2 = prev1; int returnMe = 0;
            if (numbers.get(0) == numbers.get(1)) returnMe++;
            for (int i = 0; i < numbers.size(); i++) {
                prev2 = prev1; prev1 = track;
                track = numbers.get(i);
                if (track == prev1 && prev1 != prev2) {
                    returnMe++;
                }
            }
            return returnMe;
        }
        return -1;
    }
}
