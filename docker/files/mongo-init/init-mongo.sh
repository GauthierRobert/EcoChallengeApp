echo 'Start of script'
mongo -- "$MONGODB_DATABASE" <<EOF
var user = '$MONGODB_USER';
var passwd = '$MONGODB_PASS';
var user_admin = '$MONGO_INITDB_ROOT_USERNAME';
var passwd_admin = '$MONGO_INITDB_ROOT_PASSWORD';
var admin = db.getSiblingDB('admin');
admin.auth(user_admin, passwd_admin);
db.createUser({user: user, pwd: passwd, roles: ["readWrite", "dbOwner"]});
db.getUsers({ filter: { mechanisms: "SCRAM-SHA-256" } });
db.auth(user, passwd);
db.getRole( "readWrite", { showPrivileges: true } );
EOF
echo 'End of script'