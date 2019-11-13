package acmeshoes.store.service;

import acmeshoes.store.service.model.PdpData;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PdpService {

    public Mono<PdpData> getProductPage(String productId) {
        return null;
    }
}
