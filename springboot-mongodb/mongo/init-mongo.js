// db.getSiblingDB() 相当于 use admin;
db.getSiblingDB('admin')
    .createUser({
        user: 'user',
        pwd: 'user',
        roles: ['readWrite']
    });