package filedata;

public interface Iterator{

    public boolean hasNext();
    
    public Object next();

    public Object current();
}