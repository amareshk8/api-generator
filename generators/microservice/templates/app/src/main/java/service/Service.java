package <%= packageName %>.service;

import <%= packageName %>.entity.<%= entityName %>;
import <%= packageName %>.repository.<%= entityName %>Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class <%= appName %>Service {

    public  <%= entityName %>Repository <%= entityName %>RepositoryObj;

    @Autowired
    public <%= appName %>Service(<%= entityName %>Repository <%= entityName %>RepositoryObj) {
        this.<%= entityName %>RepositoryObj = <%= entityName %>RepositoryObj;
    }

    public List<<%= entityName %>> findAll<%= appName %>s() {
        return <%= entityName %>RepositoryObj.findAll();
    }

    public Optional<<%= entityName %>> find<%= appName %>ById(Long id) {
        return <%= entityName %>RepositoryObj.findById(id);
    }

    public <%= entityName %> save<%= appName %>(<%= entityName %> obj) {
        return <%= entityName %>RepositoryObj.save(obj);
    }

    public void delete<%= appName %>ById(Long id) {
        <%= entityName %>RepositoryObj.deleteById(id);
    }
}
