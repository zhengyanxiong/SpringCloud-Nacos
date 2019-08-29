

package io.agilefast.authserver.common.utils;

/**
 * 常量
 *
 * @author
 * @since 1.0.0 2016-11-15
 */
public class Constant {
	/** 超级管理员ID */
	public static final int SUPER_ADMIN = 1;
    /** 数据权限过滤 */
	public static final String SQL_FILTER = "sql_filter";
    /** 项目数据权限过滤 */
	public static final String PROJECT_SQL_FILTER="project_sql_filter";

    /** 系统操作日志图标常量-登录 */
	public static final String LOGICON_LOGIN="fa-key";
    /** 系统操作日志图标常量-新增 */
	public static final String LOGICON_ADD="fa-plus";
    /** 系统操作日志图标常量-编辑 */
	public static final String LOGICON_EDIT="fa-edit";
    /** 系统操作日志图标常量-删除 */
	public static final String LOGICON_DELETE="fa-ban";
    /** 系统操作日志图标常量-其他 */
	public static final String LOGICON_OTHER="fa-warning";
    /** 系统操作日志图标常量-查询 */
    public static final String LOGICON_QUERY="fa-search";

	/**
	 * 菜单类型
	 */
    public enum MenuType {
        /**
         * 目录
         */
    	CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
    	NORMAL(0),
        /**
         * 暂停
         */
    	PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
    * 用户角色更新模式
    */
    public enum RoleUpdateMode {
        /**
         * 单个
         */
        SINGLE(0),
        /**
         * 批量
         */
        BATCH(1),
        /**
         * 全部
         */
        ALL(2);

        private final int key;

        RoleUpdateMode(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }
    }

    /**
     * 项目权限更新模式
     */
    public enum ProjectUpdateMode {
        /**
         * 单个
         */
        SINGLE(0),
        /**
         * 批量
         */
        BATCH(1),
        /**
         * 全部
         */
        ALL(2);

        private final int key;

        ProjectUpdateMode(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }
    }

}
