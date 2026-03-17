@DataProvider(name = "jsonUsers")
public Object[][] getUsers() {
    List<UserData> users = JsonReader.readUsers();

    Object[][] data = new Object[users.size()][1];

    for (int i = 0; i < users.size(); i++) {
        data[i][0] = users.get(i);
    }

    return data;
}