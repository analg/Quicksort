public class MuQuickSort implements SortI {
	/**
	 * Recursively QuickSort array in place.
	 *
	 * @param arr to be sorted
	 */
	@Override
	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	/**
	 * Recursively QuickSort array in place.
	 *
	 * @param arr to be sorted
	 * @param low partition index
	 * @param high partition index
	 */
	protected void sort(int[] arr, int low, int high) {

		if (high - low < 1) {
			return;
		}

		int pIndex = (high + low) / 2;
		int pivot = arr[pIndex];
		int left = low;
		int right = high;

		while (left < right) {
			// indices approach pivot until order is abnormal
			while (arr[left] < pivot || (arr[left] == pivot && left < pIndex)) {
				left++;
			}
			while (arr[right] > pivot || (arr[right] == pivot && right > pIndex)) {
				right--;
			}

			// swap left and right indices
			int templ = arr[left];
			arr[left] = arr[right];
			arr[right] = templ;

			// if pivot was involved swap accordingly
			if (left == pIndex) {
				pIndex = right;
			}
			else if (right == pIndex) {
				pIndex = left;
			}
		}

		// sort left and right subpartitions
		sort(arr, low, left - 1);
		sort(arr, left + 1, high);
	}

}
