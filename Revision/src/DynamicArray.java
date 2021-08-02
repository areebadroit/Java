public class DynamicArray{
    private int data[];
    private int nextIndex;
    //constructor
    public DynamicArray(){
        this.data = new int[5];
        this.nextIndex = 0;
    }
    //size
    public int size(){
        return this.nextIndex;
    }
    //add elements in the dynamic array
    public void add(int element){
        if(data.length==nextIndex)
        //if the present size limit is exceeded call the restructure function
            restructure();
        data[this.nextIndex] = element;
        this.nextIndex++;
    }
    //set element at a paticular index
    public void set(int index, int element){
        if(index > nextIndex)
            return;
        if(index < nextIndex)
            data[index] = element;
        else
            add(element);
    }
    //get element at a particular index
    public int get(int index){
        if(index >= nextIndex)
            return -1;
        return data[index];
    }
    //check if the array is empty
    public boolean isEmpty(){
        return this.nextIndex == 0;
    }
    //remove the last element from the array
    public int removeLast(){
        if(this.nextIndex==0) 
            return -1;
        int value = data[nextIndex-1];
        nextIndex--;
        return value;
    }
    //increasing the size of array by one
    private void restructure(){
        int temp[] = data;
        data = new int[nextIndex+1];
        for(int i=0;i<temp.length;i++)
            data[i]=temp[i];
    }
}