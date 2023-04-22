import domain.Advogado.Model.Advogado;
import domain.Advogado.Model.Estado;
import domain.Processo.Model.Processo;
import domain.Processo.Model.TipoDeAcao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle-fiap");
        EntityManager manager = factory.createEntityManager();

        save(factory, manager);
        findById(manager);
        findAll(manager);

    }
    private static void findAll(EntityManager manager) {
        String jpql = "FROM Processo";
        List<Processo> resultList = manager.createQuery(jpql).getResultList();
        resultList.stream().forEach(System.out::println);
    }
    private static void findById(EntityManager manager) {
        Processo processo = manager.find(Processo.class, 1L);
        System.out.println(processo);
    }
    private static void save(EntityManagerFactory factory, EntityManager manager) {
        Estado estado = new Estado();
        estado.setNome("São Paulo").setSigla("SP");
        TipoDeAcao tpacao = new TipoDeAcao();
        tpacao.setNome("Ação de alimentos");
        Advogado advogado = new Advogado();
        advogado.setNome("Luan Victor da Silva Sá").setNumeroOAB("93057");

        Processo alimentos = new Processo();
        alimentos.setAdvogado(advogado).setTipoDeAcao(tpacao).setNumero("02072004").setProBono(true).setDataDeDistribuicao(LocalDate.now());

        manager.getTransaction().begin();
        manager.persist(estado);
        manager.persist(tpacao);
        manager.persist(advogado);
        manager.persist(alimentos);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
