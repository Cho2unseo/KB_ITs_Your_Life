package ch13.sec02.exam01;

// 타입 파라미터를 두 개 사용할 경우 두 개의 알파벳 지정
public class Product<K, M> {
    // 타입 파라미터는 필드, 리턴값, 매개변수 타입으로 모두 사용 가능
    private K kind;
    private M model;

    public K getKind() { return this.kind; }
    public M getModel() { return model; }

    public void setKind(K kind) { this.kind = kind; }
    public void setModel(M model) { this.model = model; }
}
