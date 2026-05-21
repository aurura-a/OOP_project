package university.data;

import java.io.Serializable;

public abstract class SerializableModel implements Serializable {
    private static final long serialVersionUID = 1L;

    // Адаптируем под твой контракт: ID должен быть String (STU-0001, CRS-0001)
    protected String id; 

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (this.id == null) {
            this.id = id;
        } else {
            throw new IllegalStateException("Field 'id' is immutable and cannot be changed once set.");
        }
    }

    /** Краткое описание в одну строку для списков и меню */
    public abstract String asLine();

    /** Детальное многострочное описание */
    public abstract String asTable();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SerializableModel other = (SerializableModel) obj;
        if (id == null || other.id == null) return false;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }
}