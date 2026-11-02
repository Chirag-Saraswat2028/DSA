class Question8 {
	  public static Integer firstNonRepeating(int[] arr) {
	        int n = arr.length;

	        for (int i = 0; i < n; i++) {
	            boolean isRepeating = false;

	            for (int j = 0; j < n; j++) {
	                if (i != j && arr[i] == arr[j]) {
	                    isRepeating = true;
	                    break; 
	                }
	            }
	            if (!isRepeating) {
	                return arr[i];
	            }
	        }
	        return null;
	    }
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, -1, 2, 1, 0, 4, -1, 7, 8};
		System.out.println(firstNonRepeating(arr));
	}

}
