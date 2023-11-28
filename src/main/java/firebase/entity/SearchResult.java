package firebase.entity;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class SearchResult<T> implements Iterable<T>, AutoCloseable {
    private int totalCount;
    private List<T> list;

    public SearchResult(int totalCount, List<T> list){
        this.totalCount = totalCount;
        this.list =list;
    }

    public int getTotalCount(){
        return this.totalCount;
    }

    public List<T> getList() {
        return this.list == null ? Collections.emptyList() : this.list;
    }

    public T getFirst(){
        if (this.list == null){
            return null;
        }else {
            return this.list.size() == 0 ? null : this.list.get(0);
        }
    }

    public <P> List<P> getValueList(String propertyName){
        if (this.list != null && this.list.size() != 0){
            if (!(this.list.get(0) instanceof Entity)){
//                throw new
            }
        }
        return null;
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
