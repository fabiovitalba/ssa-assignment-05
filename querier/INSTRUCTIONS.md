# Hands-on instructions

This repository contains the boilerplate of a Web server. The domain is not implemented, but there are some hints on what to do:

- the tests in `src/test/java/it.unibz.bulletify.querier` checks whether the correct behavior is in place, but also work as documentation;
- there are empty classes in `src/main/java/it.unibz.bulletify.querier`, and they're all the classes needed to fulfill the specification of the tests.

You're supposed to implement the Web server so that the tests all pass.

1. start by implementing the `core.Item` class
2. define the query to be made against the database in the `core.ItemRepository` interface
3. implement the domain service `core.SearchItems` class -- this is the first class covered with tests
4. define the contract of the API with the `app.ItemsDTO` -- check what the tests tell you regarding what's the expected input
5. provide an implementation of the API using the `app.SearchItemsController` -- have the tests guide this implementation
6. (for verification purposes) make some data available with the `app.Seeder`