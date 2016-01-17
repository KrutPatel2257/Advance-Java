public class BubbleSort {
	int[] array;
	int size;
	
	public BubbleSort(int[] array, int size) {
		this.array = array;
		this.size = size;
	}
	
	public int[] sort() {
		for (int i = 0; i < ( size - 1 ); i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (array[j] > array[j+1])
		        {
					int temp       = array[j];
					array[j]   = array[j+1];
					array[j+1] = temp;
		        }
	      	}
		}
	return array;
	}
}