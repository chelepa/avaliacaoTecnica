package builder;

import br.com.avaliacaoTecnica.entities.AssociateEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AssociateServiceImplBuilder {

    public static Optional<AssociateEntity> MockAssociateResponse() throws IOException {
        AssociateEntity response = new AssociateEntity();
        response.setCpf("03300121000");
        response.setName("Claudimir Chelepa");
        return Optional.of(response);
    }

    public static List<AssociateEntity> MockAssociateResponseList() throws IOException {
        List<AssociateEntity> list = new ArrayList<>();
        AssociateEntity response = new AssociateEntity();
        response.setCpf("03300121000");
        response.setName("Claudimir Chelepa");

        list.add(response);
        return list;
    }
}
