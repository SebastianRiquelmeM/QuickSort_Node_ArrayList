import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Collections;

public class QuickSort {
  public static class Node{
    public String Province;
    public String Date;
    public Node(){
      Province="";
      Date="";
    }
  }
	public static void main(String[] args)throws Exception  {
	    List<Node> list = new ArrayList<Node>();
      Node a = new Node();
      Node b = new Node();
      Node c = new Node();
      Node d = new Node();
      Node e = new Node();
      Node f = new Node();

      a.Date = "01.01.2020";
      b.Date = "03.01.2020";
      c.Date = "02.01.2020";
      d.Date = "05.01.2020";
      e.Date = "04.01.2020";
      f.Date = "01.02.2020";

      list.add(a);
      list.add(b);
      list.add(c);
      list.add(d);
      list.add(e);
      list.add(f);

	    //Before sort
	    for(int i=0;i<list.size();i++){
  	    System.out.println(list.get(i).Date);
      }
	    //After sort
        list = quicksort(list);

      System.out.println("\n Fechas ordenadas: \n");
      for(int i=0;i<list.size();i++){
  	    System.out.println(list.get(i).Date);
      }
	}


	public static List<Node> quicksort(List<Node> list)throws Exception {
    SimpleDateFormat DateFormat = new SimpleDateFormat("dd.MM.yyyy");
		if(list.size() <= 1){
			return list;
		}
		int middle = (int) Math.ceil((double)list.size() / 2);
		long pivot = DateFormat.parse(list.get(middle).Date).getTime();

		List<Node> less = new ArrayList<Node>();
		List<Node> greater = new ArrayList<Node>();

		for (int i = 0; i < list.size(); i++) {
			if(DateFormat.parse(list.get(i).Date).getTime()<= pivot){
				if(i == middle){
					continue;
				}
				less.add(list.get(i));
			}
			else{
				greater.add(list.get(i));
			}
		}
		return concatenate(quicksort(less), list.get(middle), quicksort(greater));
	}

	public static List<Node> concatenate(List<Node> less, Node pivot, List<Node> greater)throws Exception {
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < less.size(); i++) {
			list.add(less.get(i));
		}
     // Agregar el nodo pivot al medio

		list.add(pivot);
		for (int i = 0; i < greater.size(); i++) {
			list.add(greater.get(i));
		}
		return list;
	}
}
