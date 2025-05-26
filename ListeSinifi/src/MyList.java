public class MyList <T>{
    int capacity;//dizinin kapasitesi
    T[] list;//dinamik array
    T[] listTemp;
    int listSize = 0;

    public MyList(){ //Dizinin varsayılan boyutu 10
        this.capacity = 10;
        this.setList();
    }
    public MyList(int capacity){
        this.capacity = capacity;
        this.setList();
    }

    public int size(){//dizideki eleman sayısını verir
        return  this.listSize;
    }

    public int getCapacity(){//dizinin kapasite değerini verir
        return capacity;
    }

    public void add(T data){
        //diziye eleman eklemek için kullanılır.Eğer dizide yeterince yer yoksa, dizi boyutu 2 katına çıkartılır.
        if(this.size() < this.capacity){
            list[this.listSize] = data;
            this.calculateSize();
        }else {
            this.capacity = this.capacity*2;
            this.pCapacity();
            this.add(data);
        }
    }

    public  T get(int index){
        T x=this.list[index];
        return  x;
    }

    public void remove(int index) {
        replaceForRemove(index);
        this.listSize--;
    }

    public void set(int index, T data) {
        //verilen indisteki veriyi yenisi ile değiştirme işlemini yapar
        this.list[index] = data;
    }

    @Override
    public String toString(){//dizideki elemanları listeler
        System.out.print("[");
        for (T x:list){
            if (x!= null){
                System.out.print(x+ ",");
            }
        }
        System.out.println("]");
        return "";
    }

    public int indexOf(T data){
        //Parametrede verilen nesnenin listedeki indeksini verir.Nesne listede yoksa -1 döndürür
        for (int i =0 ; i<this.list.length;i++){
            if (data == this.list[i]){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){//Belirtilen öğenin listedeki son indeksini söyler
        int lastIndex =-1;
        for (int i = 0; i<this.list.length;i++ ){
            if (data ==this.list[i]){
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public boolean isEmpty(){//Listenin boş olup olmadığını söyler.
        if (this.size()==0){
            return true;
        }
        else {
            return false;
        }
    }

    public Object[] toArray(){ //Listedeki öğeleri, aynı sırayla bir array haline getirir.
        Object[] tempObject =new Object[this.list.length];
        for (int i =0;i<this.list.length;i++){
            tempObject[i] = this.list[i];
        }
        return tempObject;
    }

    public void clear(){//Listedeki bütün öğeleri siler, boş liste haline getirir.
        for (int i=0;i<this.list.length;i++){
            this.list[i] =null;
        }
    }

    public MyList<T> subList(int start, int finish){
       // Parametrede verilen indeks aralığına ait bir liste döner.
        MyList<T> sub =new MyList<>(finish-start+1);
        for (int i=start;i<=finish;i++){
            sub.add((T)this.list[i]);
        }
        return sub;
    }

    public boolean contains(T data){//Parametrede verilen değerin dizide olup olmadığını söyler.
        for (int i=0;i<this.list.length;i++){
            if (data ==this.list[i]){
                return true;
            }
        }
        return false;
    }
    public void pCapacity(){
        this.listTemp = (T[]) new Object[this.capacity];
        for (int i = 0; i < this.list.length; i++){
            this.listTemp[i] = this.list[i];
        }
        this.list = this.listTemp;
    }


    public void calculateSize(){
        int c = 0;
        for (int i = 0; i < this.list.length; i++){
            if (this.list[i] != null){
                c++;
            }
        }
        this.listSize = c;
    }


    public void replaceForRemove(int index){
        T[] listTemp2 = this.list;
        this.list[index] = null;
        for(int i=0;i<listTemp2.length-1;i++){
            if(index==0){
                this.list[i]=listTemp2[i+1];
            }else if (index!=0 && i<index){
                this.list[i] =listTemp2[i];
            } else if (index!=0 && i>index ) {
                this.list[i] = listTemp2[i+1];

            }
        }
    }

    public void setList(){
        this.list = (T[]) new Object[this.capacity];
    }


}