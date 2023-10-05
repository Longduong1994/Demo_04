package demo_04.model.service.mapper;

public interface IGenericMapper <K,T,V>{
    V toResponse(K k);
    K toEntity(T t);
}
