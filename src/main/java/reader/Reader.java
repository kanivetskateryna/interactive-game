package reader;

import java.io.IOException;

/**
 * A generic interface defining a basic reading operation.
 * This interface is intended to provide a framework for reading and processing data of any specified type.
 * Implementations of this interface should specify how the data is read and processed based on the type {@code T}.
 *
 * @param <T> the type of the data to be read and returned by the read method
 */
public interface Reader<T> {

    /**
     * Reads data of type {@code T} and returns a processed version of the same type.
     * This method should be implemented to define specific reading and processing behavior suitable for the data type.
     *
     * @param input the input data of type {@code T} to be processed
     * @return the processed data of type {@code T}
     * @throws IOException if an error occurs during the reading process
     */
    T read(T input) throws IOException;
}

