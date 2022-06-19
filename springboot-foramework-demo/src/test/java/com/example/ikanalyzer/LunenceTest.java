package com.example.ikanalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.FileDescriptor;

/**
 * @author：Zik
 * @Date：Created in 2020/9/9
 * @Description:
 */


public class LunenceTest {
    // 创建索引
//    @Test
    public void testCreate() throws Exception{
//        //1 创建文档对象
//        Document document = new Document();
//        // 创建并添加字段信息。参数：字段的名称、字段的值、是否存储，这里选Store.YES代表存储到文档列表。Store.NO代表不存储
//        document.add(new StringField("id", "1", Field.Store.YES));
//        // 这里我们title字段需要用TextField，即创建索引又会被分词。StringField会创建索引，但是不会被分词
//        document.add(new TextField("title", "谷歌地图之父跳槽facebook", Field.Store.YES));
//
//
//
//        // 索引目录类,指定索引在硬盘中的位置
        Directory directory = FSDirectory.open(new File("d:\\indexDir").toPath());
//        // 引入IK分词器
//        Analyzer analyzer = new IKAnalyzer();
//        // 索引写出工具的配置对象
//        IndexWriterConfig conf = new IndexWriterConfig(Version.LATEST, analyzer);
//        // 设置打开方式：OpenMode.APPEND 会在索引库的基础上追加新索引。OpenMode.CREATE会先清空原来数据，再提交新的索引
//        conf.setOpenMode(IndexWriterConfig.OpenMode.APPEND);
//
//        // 创建索引的写出工具类。参数：索引的目录和配置信息
//        IndexWriter indexWriter = new IndexWriter(directory, conf);
//        // 把文档集合交给IndexWriter
//        indexWriter.addDocuments(docs);
//        // 提交
//        indexWriter.commit();
//        // 关闭
//        indexWriter.close();
    }
}
