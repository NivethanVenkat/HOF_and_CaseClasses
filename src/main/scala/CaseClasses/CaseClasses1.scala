package CaseClasses
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object CaseClasses1 {
  case class User(user_id: Int, user_name: String, user_city: String)
  def main(args: Array[String]): Unit = {
    println("Starting Application")
    val spark = SparkSession.builder().appName("Create spark Dataframe").master( "local")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")
    //    First Approach
    println("Approach 1: ")

    val users_details = List((1,"Alex","Canada"),(2,"Martin","New york"),(3,"Sam","Sydney"),(4,"Jack","Perth"))

    val df_columns = Seq("user_id","user_name","user_city")
    val users_rdd = spark.sparkContext.parallelize(users_details)

    val users_df = spark.createDataFrame(users_rdd)
    users_df.show(4,false)

    //    println(users_df.getClass())

    val users_df_1 = users_df.toDF(df_columns:_*)
    users_df_1.show(numRows = 4,false)

    //    println(users_df_1.getClass())

    //    Second Approach
    import spark.sqlContext.implicits._
    println("Approach 2: ")
    val users_seq = Seq(Row(1,"Alex","Canada"),Row(2,"Martin","New york"),Row(3,"Sam","Sydney"),Row(4,"Jack",null))

    val users_schema = StructType(Array(StructField("user_id",IntegerType,true),
      StructField("user_name",StringType,true),StructField("user_city",StringType,true)))

    val users_df_2 = spark.createDataFrame(spark.sparkContext.parallelize(users_seq),users_schema)
    users_df_2.show(4,false)

    //    Third Approach
    println("Approach 3: ")

    val case_users_seq = Seq(User(1,"Alex","Canada"),User(2,"Martin","New york"),User(3,"Sam","Sydney"),User(4,"Jack",null))

    val case_users_df = spark.createDataFrame(spark.sparkContext.parallelize(case_users_seq))
    case_users_df.show(4,false)

    spark.stop()
    println("Ending Application")
  }
}