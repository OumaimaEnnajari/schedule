package com.example.edt_k.Web;

import com.example.edt_k.entity.AppRole;
import com.example.edt_k.entity.AppUser;
import com.example.edt_k.service.AccountService;
import lombok.Data;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
public class AccountRestController implements Serializable {
    AccountService accountService;

    public AccountRestController(AccountService accountService)
    {
        this.accountService=accountService;
    }
    @GetMapping(path = "/users", produces = "application/json")
    public ResponseEntity<List<AppUser>> listUsers() {
        List<AppUser> users = accountService.listUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping(path = "/adduser", produces = "application/json", consumes = "application/json")
    public AppUser addNewUser(@RequestBody AppUser user) {
        return accountService.AddNewUser(user);
    }

    @PostMapping("/addrole")
    AppRole AddNewRole( @RequestBody AppRole role)
    {
        return accountService.AddNewRole(role);
    }

    @PostMapping("/addroletouser")
    void addRoleToUser(@RequestBody userRoleForm userroleForm)
    {
        accountService.AddRoleToUser(userroleForm.getUsername(), userroleForm.getRolename());
    }
}
@Data
class userRoleForm
{
    String username;
    String rolename;

}
