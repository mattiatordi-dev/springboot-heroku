package com.example.demo.security.models;

public class UserRoleModel
{
   public static final String ROLE_SITE_ADMIN = "SITE_ADMIN";
   public static final String ROLE_SITE_USER = "SITE_USER";
   
   private int roleId;
   private String roleName;
   
   public int getRoleId()
   {
      return roleId;
   }

   public void setRoleId(int roleId)
   {
      this.roleId = roleId;
   }

   public String getRoleName()
   {
      return roleName;
   }

   public void setRoleName(String roleName)
   {
      this.roleName = roleName;
   }
}
