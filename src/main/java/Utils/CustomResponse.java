package Utils;

import java.util.List;

public class CustomResponse<T> {
    public List<T> items;
    public long total;
    public int page;
    public int size;
}
