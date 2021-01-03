package service.impl;

import org.springframework.stereotype.Service;
import service.ConvertService;
@Service
public class CovertServiceImpl implements ConvertService {
    @Override
    public double convertUsdToVnd(double usd) {
        return usd*23000;
    }
}
