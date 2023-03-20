package Lists;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ArrayList<String> array = new ArrayList<String>();
       
       array.add("Sriram");
       array.add("king Manova");
       
       System.out.println(array.toString());
       System.out.println(array.size());
       System.out.println(array.indexOf("Sriram"));
       System.out.println(array.get(1));
       System.out.println(array.pop());
       System.out.println(array.toString());
       array.shift("King Manova");
       System.out.println(array.toString());
       array.insert(1,"Smith");
       System.out.println(array.toString());
       array.remove("Sriram");
       System.out.println(array.toString());
       array.addAll("Benny","Somu");
       System.out.println(array.toString());
       System.out.println(array.contains("Somu"));
       array.unshift();
       System.out.println(array.toString());
       
       array.forEach(Names -> {
    	   System.out.println(Names);   
       });
       try {
		System.out.println(array.clone());
	    } catch (CloneNotSupportedException e) {
		e.printStackTrace();
	}
      array.set(0,"Neveen");
      System.out.println(array.toString());
      
	}

}
