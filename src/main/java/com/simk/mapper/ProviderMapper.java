package com.simk.mapper;

import com.simk.entities.Provider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProviderMapper {
    List<Provider> getProviders(Provider provider);
    Provider getProviderByPid(Integer pid);
    int addProvider(Provider provider);
    int deleteProvider(Integer pid);
    int updateProvider(Provider provider);

}
