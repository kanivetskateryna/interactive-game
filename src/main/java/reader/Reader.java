package reader;

import java.io.IOException;

public interface Reader<T> {

    T read(T input) throws IOException;
}
