package cn.segema.learn.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**@description flink-stream测试
 * nc -l -p 9000
 * @author wangyong
 * @createDate 2020/05/07
 */
public class StreamingJobDemo {
    public static void main(String[] args) throws Exception {
        // set up the streaming execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> text = env.socketTextStream("10.10.143.147", 9000);
        DataStream<Tuple2<String, Integer>> dataStream =
            text.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
                @Override
                public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                    String[] tokens = s.toLowerCase().split("\\W+");

                    for (String token : tokens) {
                        if (token.length() > 0) {
                            collector.collect(new Tuple2<String, Integer>(token, 1));
                        }
                    }
                }
            }).keyBy(0).timeWindow(Time.seconds(5)).sum(1);

        dataStream.print();
        env.execute("Java WordCount from SocketTextStream Example");
    }

}
