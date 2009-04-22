module demo::GenericFeatherweightJava::TypeConstraints
import demo::GenericFeatherweightJava::GFJ;

data TypeOf = typeof(Expr expr) | typeof(Method method) | typeof(Name fieldName) | typeof(Type typeId);  

data Constraint = eq(TypeOf a, TypeOf b) |
                  subtype(TypeOf a, TypeOf b) |
                  subtype(TypeOf a, set[TypeOf] alts);
                  


