//task4       (Muhammad_Shahzeb_0047)
class task4{
	public static void main(String[] args){
		int[]array={1, 4, 9, 16, 25, 36, 49, 64, 81, 0};

		int sum=0;
		int j=0;

		while(j<array.length){
			
			if(array[j]%3==1){
				sum+=array[j];
			}
			j++;

			if(array[j]==81){
				break;
			}
		}
		System.out.println("Sum of all odd numbers till 81 : "+sum);

		}
	}
