package <%= packageName %>.controller;

import <%= packageName %>.entity.<%= entityName %>;
import <%= packageName %>.service.<%= appName %>Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/<%= pathName %>")
@Slf4j
public class <%= appName %>Controller {

    private final <%= appName %>Service  <%= appName %>ServiceObJ;

    @Autowired
    public <%= appName %>Controller(<%= appName %>Service <%= appName %>ServiceObJ) {
        this.<%= appName %>ServiceObJ = <%= appName %>ServiceObJ;
    }

    @GetMapping
    public List<<%= entityName %>> getAll<%= appName %>s() {
        return <%= appName %>ServiceObJ.findAll<%= appName %>s();
    }

    @GetMapping("/{id}")
    public ResponseEntity<<%= entityName %>> get<%= appName %>ById(@PathVariable Long id) {
        return <%= appName %>ServiceObJ.find<%= appName %>ById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public <%= entityName %> create<%= appName %>(@RequestBody @Validated <%= entityName %> var1) {
        return <%= appName %>ServiceObJ.save<%= appName %>(var1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<<%= entityName %>> update<%= appName %>(@PathVariable Long id, @RequestBody <%= entityName %> var1) {
        return <%= appName %>ServiceObJ.find<%= appName %>ById(id)
                .map(<%= entityName %> -> {
                    var1.setId(id);
                    return ResponseEntity.ok(<%= appName %>ServiceObJ.save<%= appName %>(var1));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<<%= entityName %>> delete<%= appName %>(@PathVariable Long id) {
        return <%= appName %>ServiceObJ.find<%= appName %>ById(id)
                .map(<%= appName %> -> {
                    <%= appName %>ServiceObJ.delete<%= appName %>ById(id);
                    return ResponseEntity.ok(<%= appName %>);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
