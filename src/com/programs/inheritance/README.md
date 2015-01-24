Rules for method overriding:
----------------------------

1. The argument list should be exactly the same as that of the overridden method.

2. The return type should be the same or a subtype of the return type declared in the original overridden method in the superclass.

3. The access level cannot be more restrictive than the overridden method's access level. For example: if the superclass method is declared public then the overridding method in the sub class cannot be either private or protected.

4. Instance methods can be overridden only if they are inherited by the subclass.

5. A method declared final cannot be overridden.

6. A method declared static cannot be overridden but can be re-declared.

7. If a method cannot be inherited, then it cannot be overridden.

8. A subclass within the same package as the instance's superclass can override any superclass method that is not declared private or final.

9. A subclass in a different package can only override the non-final methods declared public or protected.

10. An overriding method can throw any uncheck exceptions, regardless of whether the overridden method throws exceptions or not. However the overriding method should not throw checked exceptions that are new or broader than the ones declared by the overridden method. The overriding method can throw narrower or fewer exceptions than the overridden method.

11. Constructors cannot be overridden.
