package utils;


import entities.Recipe;
import entities.Role;
import entities.Ingeriedents;
import entities.User;
import entities.WeekMenu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    User user = new User("user", "test123");
    User admin = new User("admin", "test123");
    User both = new User("user_admin", "test123");
    

      WeekMenu w1 = new WeekMenu(1, 2020);
      WeekMenu w2 = new WeekMenu(2, 2020);
      WeekMenu w3 = new WeekMenu(3, 2020);
      WeekMenu w4 = new WeekMenu(4, 2020);
      WeekMenu w5 = new WeekMenu(5, 2020);
      WeekMenu w6 = new WeekMenu(6, 2020);
      WeekMenu w7 = new WeekMenu(7, 2020);
    
    Recipe r1 = new Recipe("PotatoSoop","45 min", "Potato Soop, Boil Potatos, blend and and milk and water");
    Recipe r2 = new Recipe("Scrambled Egg", "15 min", "Boiled egg, boil eg for 8 min");
    Recipe r3 = new Recipe("Lasange", "1 hour", "Add meat to tomato");
    Recipe r4 = new Recipe("Hot Dogs", "25 min", "Warm bread");
    Recipe r5 = new Recipe("Pasta", "15 min", "Warm the pasta ");
    Recipe r6 = new Recipe("Burger", "35 min", "Every Thing is cut");
    Recipe r7 = new Recipe("Cheese Burger", "25 min", "Same as burger but add Cheese");
    Recipe r8 = new Recipe("Toast", "10 hour", "Toast to be warmed in the freezer");
    
    Ingeriedents i1 = new Ingeriedents("Potato", "1");
    Ingeriedents i2 = new Ingeriedents("Egg", "1");
    Ingeriedents i3 = new Ingeriedents("Pasta", "100g");
    Ingeriedents i4 = new Ingeriedents("Tomato", "1");
    Ingeriedents i5 = new Ingeriedents("Meat", "150");
    Ingeriedents i6 = new Ingeriedents("Canned Tomato", "1");
    Ingeriedents i7 = new Ingeriedents("Chesse", "1 slice");
    Ingeriedents i8 = new Ingeriedents("Bread", "1 slice");
    Ingeriedents i9 = new Ingeriedents("Chillie", "1");
    Ingeriedents i10 = new Ingeriedents("Mikl", "1 cup");
   
    r1.addIngriedentsToRecipe(i1);
    r2.addIngriedentsToRecipe(i2);
    r2.addIngriedentsToRecipe(i9);
    r2.addIngriedentsToRecipe(i7);
    r2.addIngriedentsToRecipe(i6);
    r5.addIngriedentsToRecipe(i4);
    r5.addIngriedentsToRecipe(i3);
    r4.addIngriedentsToRecipe(i5);
    r4.addIngriedentsToRecipe(i8);
    r6.addIngriedentsToRecipe(i8);
    r6.addIngriedentsToRecipe(i5);
    r7.addIngriedentsToRecipe(i8);
    r7.addIngriedentsToRecipe(i5);
    r8.addIngriedentsToRecipe(i7);
    r8.addIngriedentsToRecipe(i5);

    w1.addRecipeToWeekMenu(r1);
    w1.addRecipeToWeekMenu(r2);
    w1.addRecipeToWeekMenu(r3);
    w1.addRecipeToWeekMenu(r4);
    w1.addRecipeToWeekMenu(r5);
    w1.addRecipeToWeekMenu(r6);
    w1.addRecipeToWeekMenu(r7);
    
    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
   
     

    em.persist(r1);
    em.persist(r2);
    em.persist(r3);
    em.persist(r4);
    em.persist(r5);
    em.persist(r6);
    em.persist(r7);
    em.persist(r8);
   
    em.persist(w1);
    em.persist(w2);
    em.persist(w3);
    em.persist(w4);
    em.persist(w5);
    em.persist(w6);
    em.persist(w7);
    
      System.out.println("Heyayaya");
    
    
    
    
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
   
  }

}
