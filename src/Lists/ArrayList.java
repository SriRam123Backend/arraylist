package Lists;

import java.io.Serializable;
import java.util.function.Consumer;

public final class ArrayList<T> implements Serializable,Cloneable {
	
	    private static final long serialVersionUID = 1L;
		private Object[] elements;
	    private int size;
	    private static final int capacity = 10;

	    public ArrayList() {
	        elements = new Object[capacity];
	        size = 0;
	    }
	    
	    public ArrayList(int size)
	    {
	        elements = new Object[size];
	        this.size = size;
	    }

	    public int size() {
	        return size;
	    }

	    public boolean isEmpty() {
	        return size == 0;
	    }

	    public void add(T element) {
	        if (size == elements.length) {
	            expandCapacity();
	        }
	        elements[size] = element;
	        size++;
	    }
        
	    @SuppressWarnings("unchecked")
		public void addAll(T...N){
			
			for(T element:N) {
				add(element);
			}
		}
	    
		@SuppressWarnings("unchecked")
		public void insert(int index,T element){
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	        }
			 else {
			    if (size == elements.length) {
			       expandCapacity();
			    }
			    for(int i=index;i<size+1;i++)
			    {
			       T temp = element;
			       element = (T) elements[i];
				   elements[i] = temp;
				}
			        size++;
			 }
	       
	   }
		
		public void set(int index,T element)
		{
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	        }
			 else {
				  if(size == 0)
				  {
					  size = index;
				  }
                  elements[index] = element;
			 }
		}
		
	    @SuppressWarnings("unchecked")
	    public T get(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	        }
	        return (T) elements[index];
	    }

	    public void remove(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	        }
	        for (int i = index; i < size - 1; i++) {
	            elements[i] = elements[i + 1];
	        }
	        size--;
	        elements[size] = null;
	    }

	    public boolean remove(T element) {
	        int index = indexOf(element);
	        if (index == -1) {
	            return false;
	        }
	        remove(index);
	        return true;
	    }
        
	    @SuppressWarnings("unchecked")
		public ArrayList<T> subList(int startingIndex,int LastIndex)
	    {
	    	ArrayList<T> array = new ArrayList<T>();
	    	if(size > 0)
	    	{
	    	for(int i=startingIndex;i<LastIndex;i++)
	    	{
	    		array.add((T)elements[i]);
	    	}
	    	}
	    	return array;
	    }
	    public boolean removeAll(T element)
	    {
	        int index = indexOf(element);
	        if (index == -1) {
	            return false;
	        }
	        else
	    	{
	        for (int i = index; i < size; i++) {
	             if(elements[i]== element)
	             {   
	            	 remove(i);
	             }
	          }
	          return true;
	    	}
	    }
	    public int indexOf(T element) {
	        for (int i = 0; i < size; i++) {
	            if (element.equals(elements[i])) {
	                return i;
	            }
	        }
	        return -1;
	    }
	    
	    public int lastIndexOf(T element) {
	        for (int i = size;i>=0;i--) {
	            if (element.equals(elements[i])) {
	                return i;
	            }
	        }
	        return -1;
	    }

	    private void expandCapacity() {
	        Object[] newElements = new Object[elements.length + 10];
	        for (int i = 0; i < elements.length; i++) {
	            newElements[i] = elements[i];
	        }
	        elements = newElements;
	    }
	    
	    @SuppressWarnings("unchecked")
		public void shift(T element)
	    {
	        if (size == elements.length) {
	            expandCapacity();
	        }
	        for(int i=0;i<size+1;i++)
	        {
	        	T temp = element;
	        	element = (T) elements[i];
		        elements[i] = temp;
		        
	        }
	        size++;
	    }
	    
		public void unshift(){
	    	if(size == 0) {
	    		throw new ArrayIndexOutOfBoundsException();
			 }else if(size==1){
				 elements[0]=null;
				 size--;
			 }else {
				 remove(0);
				 size--;
			 }
		}

	    public void clear()
	    {
	        elements = new Object[capacity];
	        size = 0;
	    }
	    
	    public boolean pop()
	    {
           if(size > 0)
           {
	    	remove(size-1);
	    	return true;
           }
           return false;
	    }
	    
	    public String toString() {
	    	
	    	String result = "[";
            if(size > 0)
            {
    			for(int i=0;i<size;i++) {
    				result += (String) elements[i];
    				if(i!=size-1)result +=", ";
    			}
            }
            return result+"]";

	    }
	    
		public boolean contains(T element)
	    {
	    	if(size > 0)
	    	{
	    	   for(int i=0;i<size;i++)
	    	   {
	    		   if(elements[i] == element)
	    		   {
	    			   return true;
	    		   }
	    	   }
	    	}
	    	return false;
	    }
		
		public boolean replace(T oldElement,T newElement)
		{
	        int index = indexOf(oldElement);
	        if (index == -1) {
	            return false;
	        }
	        set(index,newElement);
	        return true;
		}
		
		public boolean replaceAll(T oldElement,T newElement)
		{
	        int index = indexOf(oldElement);
	        if (index == -1) {
	            return false;
	        }
	        else
	    	{
	        for (int i = index; i < size; i++) {
	             if(elements[i]== oldElement)
	             {   
	            	 set(i,newElement);;
	             }
	          }
	          return true;
	    	}
		}
		@SuppressWarnings("unchecked")
		public void forEach(Consumer<? super T> action) {
			if(action==null)
			{
				throw new NullPointerException();
			}
			for (int i=0;i<size;i++) {
		        action.accept((T) elements[i]);
		    }
		}
		
	    @Override
	    @SuppressWarnings("unchecked")
	    public Object clone() throws CloneNotSupportedException {
			ArrayList<T> clone = (ArrayList<T>) super.clone();
	        return clone;
	    }
}

